// This C++ file includes necessary libraries, the "Grayscale.h" header file, and the "Pixel.h" header file.
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.
#include "Grayscale.h"   // Header file for the grayscale conversion function.
#include <vector>        // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply grayscale conversion to an image.
// Takes a 2D vector of Pixel objects as input and modifies it to grayscale.
void applyGrayscale(vector<vector<Pixel>> &imageVector)
{
    // Get the dimensions of the image (rows and columns).
    int m = imageVector.size();
    int n = imageVector[0].size();

    // Iterate through each pixel in the image.
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            // Calculate the grayscale value using the luminosity method.
            int grayValue = (int)(0.299 * imageVector[i][j].r + 0.587 * imageVector[i][j].g + 0.114 * imageVector[i][j].b);

            // Set the red, green, and blue components of the pixel to the grayscale value.
            imageVector[i][j].r = grayValue;
            imageVector[i][j].g = grayValue;
            imageVector[i][j].b = grayValue;
        }
    }
}
