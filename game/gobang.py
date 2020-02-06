from graphics import *
from math import *
import numpy as np

GRID_WIDTH = 40
COLUMN = 15
ROW = 15

list1 = set()  # AI
list2 = set()  # human
list3 = set()  # all
record_list = []

list_all = set([(i, j) for i in range(COLUMN + 1)
                for j in range(ROW + 1)])  # 整个棋盘的点
next_point = (0, 0)  # AI 下一步最应该下的位置

ratio = 1.2  # 进攻的系 大于 1 进攻型 小于 1 防守型
DEPTH = 3  # 搜索深度 只能是单数 如果是负数，评估函数评估的是自己多少步之后自己得分的最大值，并不意味最好的棋

# 棋型的评估分数
shape_score = [(50, (0, 1, 1, 0, 0)), (50, (0, 0, 1, 1, 0)),
               (200, (1, 1, 0, 1, 0)), (500, (0, 0, 1, 1, 1)),
               (500, (1, 1, 1, 0, 0)), (5000, (0, 1, 1, 1, 0)),
               (5000, (0, 1, 0, 1, 1, 0)), (5000, (0, 1, 1, 0, 1, 0)),
               (5000, (1, 1, 1, 0, 1)), (5000, (1, 1, 0, 1, 1)),
               (5000, (1, 0, 1, 1, 1)), (5000, (1, 1, 1, 1, 0)),
               (5000, (0, 1, 1, 1, 1)), (5000, (0, 1, 1, 1, 1, 0)),
               (999999999, (1, 1, 1, 1, 1))]
shape_score_map = dict([(key, val) for (val, (key)) in shape_score])
shape_score_set = shape_score_map.keys()


def ai():
    global cut_count
    global search_count
    global next_point
    cut_count, search_count = 0, 0
    negamax(True, DEPTH, -999999999, 999999999)
    print('本次共剪枝次数： ' + str(cut_count))
    print('本次共搜索次数： ' + str(search_count))
    print(next_point)
    return next_point


# 负值极大算法搜索 alpha + beta 剪枝
def negamax(is_ai, depth, alpha, beta):
    global next_point
    global search_count
    global cut_count

    # 游戏是否结束 || 搜索的递归深度是否到边界
    if game_win(list1) or game_win(list2) or depth == 0:
        return evaluation(is_ai)

    blank_list = list(list_all.difference(list3))
    order(blank_list)  # 搜索顺序排序 提高剪枝效率
    # 遍历每一个候选步
    for next_step in blank_list:
        search_count += 1

        # 如果要评估的位置没有相邻的子 则不去评估 减少计算
        if not has_neighbor(next_step):
            continue

        if is_ai:
            list1.add(next_step)
        else:
            list2.add(next_step)
        list3.add(next_step)
        record_list.append(next_step)

        value = -negamax(not is_ai, depth - 1, -beta, -alpha)

        if is_ai:
            list1.remove(next_step)
        else:
            list2.remove(next_step)
        list3.remove(next_step)
        del (record_list[-1])

        if value > alpha:
            print(
                str(value) + ', aplha: ' + str(alpha) + ', beta: ' + str(beta))
            if depth == DEPTH:
                next_point = next_step
            # alpha + beta 剪枝点
            if value >= beta:
                cut_count += 1
                return beta
            alpha = value
    return alpha


# 离最后落子的邻居位置最有可能是最优点
def order(blank_list):
    m, n = record_list[-1]
    last_pt_neighbors = [(m + i, n + j) for i in range(-1, 2)
                         for j in range(-1, 2)]
    last_pt_neighbors.remove((m, n))
    for item in last_pt_neighbors:
        if item in blank_list:
            blank_list.remove(item)
            blank_list.insert(0, item)


def has_neighbor(pt):
    m, n = pt[0], pt[1]
    neighbors = set([(m + i, n + j) for i in range(-1, 2)
                     for j in range(-1, 2)])
    neighbors.remove((m, n))
    return neighbors & list3


# 评估函数
def evaluation(is_ai):
    total_score = 0

    if is_ai:
        my_list = list1
        enemy_list = list2
    else:
        my_list = list2
        enemy_list = list1

    # 算自己的得分
    score_all_arr = []  # 得分形状的位置 用于计算如果有相交 得分翻倍
    my_score = 0
    for (m, n) in my_list:
        for (x_direct, y_direct) in [(0, 1), (1, 0), (1, 1), (1, -1)]:
            my_score += cal_score(m, n, x_direct, y_direct, enemy_list,
                                  my_list, score_all_arr)

    # 算敌人的得分 并减去
    score_all_arr_enemy = []
    enemy_score = 0
    for (m, n) in enemy_list:
        for (x_direct, y_direct) in [(0, 1), (1, 0), (1, 1), (1, -1)]:
            enemy_score += cal_score(m, n, x_direct, y_direct, enemy_list,
                                     my_list, score_all_arr_enemy)

    total_score = my_score - enemy_score * ratio * 0.1

    return total_score


# 每个方向上的分值计算
def cal_score(m, n, x_direct, y_direct, enemy_list, my_list, score_all_arr):
    add_score = 0  # 加分项
    # 在一个方向上 只取最大的得分项
    max_score_shape = (0, None, None)

    # 如果该方向上 该点已经有得分形状 不重复计算
    for item in score_all_arr:
        if (x_direct, y_direct) == item[2] and (m, n) in item[1]:
            return 0

    # 在落子点 左右方向上循环查找得分形状
    for offset in range(-5, 1):
        pos = []
        for i in range(0, 6):
            x = m + (i + offset) * x_direct
            y = n + (i + offset) * y_direct
            if (x, y) in enemy_list: pos.append(2)
            elif (x, y) in my_list: pos.append(1)
            else: pos.append(0)

        tmp_shape = set([tuple(pos[0:-1]), tuple(pos[:])])
        for item in (shape_score_set & tmp_shape):
            score = shape_score_map[item]
            if score > max_score_shape[0]:
                max_score_shape = (score,
                                   tuple([(m + (i + offset) * x_direct,
                                           n + (i + offset) * y_direct)
                                          for i in range(0, 5)]), (x_direct,
                                                                   y_direct))
    # 计算两个形状相交 如果两个 3 活相交 得分增加 一个子的除外
    if max_score_shape[1] is not None:
        for item in score_all_arr:
            for pt1 in item[1]:
                for pt2 in max_score_shape[1]:
                    if pt1 == pt2 and max_score_shape[0] > 10 and item[0] > 10:
                        add_score += item[0] + max_score_shape[0]
        score_all_arr.append(max_score_shape)

    return add_score + max_score_shape[0]


def game_win(point_sets):
    for (m, n) in point_sets:
        if n < ROW - 4 and len(
                set([(m, n + i) for i in range(1, 5)]) - point_sets) == 0:
            return True
        elif m < COLUMN - 4 and len(
                set([(m + i, n) for i in range(1, 5)]) - point_sets) == 0:
            return True
        elif m < COLUMN - 4 and n < ROW - 4 and len(
                set([(m + i, n + i) for i in range(1, 5)]) - point_sets) == 0:
            return True
        elif m < COLUMN - 4 and n > 3 and len(
                set([(m + i, n - i) for i in range(1, 5)]) - point_sets) == 0:
            return True
    return False


def gobangwin():
    win = GraphWin('Gobang Game', GRID_WIDTH * COLUMN, GRID_WIDTH * ROW)
    win.setBackground('yellow')

    i1 = 0
    while i1 <= GRID_WIDTH * COLUMN:
        l = Line(Point(i1, 0), Point(i1, GRID_WIDTH * COLUMN))
        l.draw(win)
        i1 += GRID_WIDTH
    i2 = 0
    while i2 < GRID_WIDTH * ROW:
        l = Line(Point(0, i2), Point(GRID_WIDTH * ROW, i2))
        l.draw(win)
        i2 += GRID_WIDTH
    return win


if __name__ == "__main__":

    win = gobangwin()

    change, g, m, n = 0, 0, 0, 0

    while g == 0:

        if change % 2 == 1:
            pos = ai()

            if pos in list3:
                message = Text(Point(200, 200),
                               "不可用的位置" + str(pos[0]) + "," + str(pos[1]))
                message.draw(win)
                g = 1

            list1.add(pos)
            list3.add(pos)
            record_list.append(pos)

            piece = Circle(Point(GRID_WIDTH * pos[0], GRID_WIDTH * pos[1]), 16)
            piece.setFill('white')
            piece.draw(win)

            if game_win(list1):
                print('list1 win: ' + str(list1))
                message = Text(Point(100, 100), "white win.")
                message.draw(win)
                g = 1
            change = change + 1

        else:
            p2 = win.getMouse()
            if not ((round(
                (p2.getX()) / GRID_WIDTH), round(
                    (p2.getY()) / GRID_WIDTH)) in list3):

                a2 = round((p2.getX()) / GRID_WIDTH)
                b2 = round((p2.getY()) / GRID_WIDTH)
                list2.add((a2, b2))
                list3.add((a2, b2))
                record_list.append((a2, b2))

                piece = Circle(Point(GRID_WIDTH * a2, GRID_WIDTH * b2), 16)
                piece.setFill('black')
                piece.draw(win)
                if game_win(list2):
                    print('list2 win: ' + str(list2))
                    message = Text(Point(100, 100), "black win.")
                    message.draw(win)
                    g = 1

                change = change + 1

    message = Text(Point(100, 120), "Click anywhere to quit.")
    message.draw(win)
    win.getMouse()
    win.close()