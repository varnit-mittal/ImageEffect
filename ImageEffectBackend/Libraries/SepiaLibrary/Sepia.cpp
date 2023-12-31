// This C++ file includes necessary libraries, the "Sepia.h" header file, and the "Pixel.h" header file.
#include "Sepia.h"     // Header file for the sepia tone application function.
#include <vector>      // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"  // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply sepia tone to an image.
// Takes a 2D vector of Pixel objects as input and modifies it by applying the sepia effect.
void applySepia(vector<vector<Pixel>> &imageVector)
{
    // Iterate through each pixel in the image.
    for (int i = 0; i < imageVector.size(); i++)
    {
        for (int j = 0; j < imageVector[i].size(); j++)
        {
            // Extract the red, green, and blue components of the pixel.
            int r = imageVector[i][j].r;
            int g = imageVector[i][j].g;
            int b = imageVector[i][j].b;

            // Apply the sepia transformation to the components.
            int newR = static_cast<int>((r * 0.393) + (g * 0.769) + (b * 0.189));
            int newG = static_cast<int>((r * 0.349) + (g * 0.686) + (b * 0.168));
            int newB = static_cast<int>((r * 0.272) + (g * 0.534) + (b * 0.131));

            // Ensure that the transformed values are within the valid color range [0, 255].
            if (newR > 255)
            {
                newR = 255;
            }
            if (newG > 255)
            {
                newG = 255;
            }
            if (newB > 255)
            {
                newB = 255;
            }

            // Update the pixel values with the sepia-toned components.
            imageVector[i][j].r = newR;
            imageVector[i][j].g = newG;
            imageVector[i][j].b = newB;
        }
    }
}
