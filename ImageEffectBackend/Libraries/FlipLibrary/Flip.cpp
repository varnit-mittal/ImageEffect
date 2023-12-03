#include<vector>
#include<math.h>
#include<algorithm>
#include "Flip.h"
#include "../Pixel.h"

using namespace std;

void applyFlip(vector<vector<Pixel>>& image, int horizontalFlipValue, int verticalFlipValue)
{
    if (horizontalFlipValue)
        for (vector<Pixel>& row : image)
            reverse(row.begin(), row.end());

    if (verticalFlipValue != 0)
        reverse(image.begin(), image.end());
 }

