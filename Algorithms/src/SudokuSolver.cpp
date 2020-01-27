#include<inttypes.h>
#include<bitset>
#include<array>
using std::bitset;

class Solution{
    
    struct cell // encapsulates a single cell on a Sudoku board
    {
        uint8_t value; // cell value 1..9 or 0 if unset
        // number of possible (unconstrained) values for the cell
        uint8_t numPossibilities;
        // if bitset[v] is 1 then value can't be v
        bitset<10> constraints;
        cell(): value(0), numPossibilities(9), constraints(){};
    };
    array<array<cell, 9>, 9> cells;
    
    // sets the value of the cell to [v]
    // the function also propagates constraints to other cells and deduce new values where possible
    bool set(int i, int j, int v)
    {
        // updating state of the cell
        cell& c = cells[i][j];
        if (c.value == v) return true;
        if (c.constraints[v]) return false;
        c.constraints = bitset<10>(0x3FE); // all 1s
        c.constraints.reset(v);
        c.numPossibilities = 1;
        c.value = v;

        // propagating constraints
        for (int k = 0; k < 9; k++)
        {
            // to the row:
            if (i != k && !updateConstraints(k,j,v))
                return false;
            // to the column:
            if (j != k && !updateConstraints(k,j,v))
                return false;

        }
    }

    // update constraints of the cell, i,j by excluding possibility of 'excludeValue'
    // once there's one possibility left the function recurses back into set()
    bool updateConstraints(int i, int j, int excludedValue)
    {
        cell& c = cells[i][j];
        if (c.constraints[excludedValue])
            return true;
        if (c.value == excludedValue)
            return false;
        c.constraints.set(excludedValue);
        if (--c.numPossibilities > 1)
            return true;
        for (int v = 1; v <= 9; v++)
        {
            if (!c.constraints[v])
                return set()
        }
    }
}
