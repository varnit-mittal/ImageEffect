// This C++ file includes necessary libraries, the "Flip.h" header file, and the "Pixel.h" header file.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include <math.h>       // Standard C library for mathematical functions.
#include <algorithm>    // Standard C++ library for algorithms.
#include "Flip.h"       // Custom header file that likely contains the definition of the Pixel structure.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply horizontal and vertical flips to an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on flip values.
void applyFlip(vector<vector<Pixel>>& image, int horizontalFlipValue, int verticalFlipValue)
{
    // Check if a horizontal flip is requested.
    if (horizontalFlipValue)
    {
        // Iterate through each row in the image and reverse the order of pixels.
        for (vector<Pixel>& row : image)
        {
            reverse(row.begin(), row.end());
        }
    }

    // Check if a vertical flip is requested.
    if (verticalFlipValue != 0)
    {
        // Reverse the order of rows in the entire image.
        reverse(image.begin(), image.end());
    }
}
