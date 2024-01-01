// This C++ file includes necessary libraries and the "Brightness.h" header file.
#include <vector>      // Standard C++ library for dynamic arrays (vectors).
#include <math.h>      // Standard C library for mathematical functions.
#include "Brightness.h"// Custom header file that likely contains the definition of the Pixel structure.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply brightness adjustment to an image represented by a 2D vector of pixels.
void applyBrightness(vector<vector<Pixel>> &imageVector, float amount)
{
    // Get the dimensions of the image (rows and columns).
    int m = imageVector.size();
    int n = imageVector[0].size();

    // Loop through each pixel in the image.
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            // Apply brightness adjustment to the red, green, and blue components of the pixel.
            imageVector[i][j].r = (int)(pow(imageVector[i][j].r, amount / 100));
            imageVector[i][j].g = (int)(pow(imageVector[i][j].g, amount / 100));
            imageVector[i][j].b = (int)(pow(imageVector[i][j].b, amount / 100));

            // Ensure that the adjusted values do not exceed the maximum intensity of 255.
            if(imageVector[i][j].r > 255)
            {
                imageVector[i][j].r = 255;
            }

            if(imageVector[i][j].g > 255)
            {
                imageVector[i][j].g = 255;
            }

            if(imageVector[i][j].b > 255)
            {
                imageVector[i][j].b = 255;
            }

            // Ensure that the adjusted values do not fall below a minimum intensity threshold of 10.
            if(imageVector[i][j].r < 10)
            {
                imageVector[i][j].r += 50;
            }

            if(imageVector[i][j].g < 10)
            {
                imageVector[i][j].g += 50;
            }

            if(imageVector[i][j].b < 10)
            {
                imageVector[i][j].b += 50;
            }
        }
    }
}
