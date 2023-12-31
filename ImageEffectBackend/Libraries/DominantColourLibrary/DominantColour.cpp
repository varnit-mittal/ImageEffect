// This C++ file includes necessary libraries, the "DominantColour.h" header file, and the "Pixel.h" header file.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include <map>          // Standard C++ library for associative containers (map).
#include <math.h>       // Standard C library for mathematical functions.
#include <algorithm>    // Standard C++ library for algorithms.
#include "DominantColour.h" // Custom header file that likely contains the definition of the Pixel structure.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply the dominant color of an image to all pixels in the image.
void applyDominantColour(vector<vector<Pixel>>& image)
{
    // Create a vector to count occurrences of each color in the image.
    vector<int> colorCount(255 << 16 | 255 << 8 | 255, 0);

    // Iterate through each pixel in the image and update the color count vector.
    for (int i = 0; i < image.size(); i++)
    {
        for (int j = 0; j < image[i].size(); j++)
        {
            int colorKey = (image[i][j].r << 16) | (image[i][j].g << 8) | image[i][j].b;
            colorCount[colorKey]++;
        }
    }

    // Find the color with the maximum occurrence in the image.
    int dominantColor = max_element(colorCount.begin(), colorCount.end()) - colorCount.begin();

    // Create a Pixel object representing the dominant color.
    Pixel dominantPixel;
    dominantPixel.r = (dominantColor >> 16) & 0xFF;
    dominantPixel.g = (dominantColor >> 8) & 0xFF;
    dominantPixel.b = dominantColor & 0xFF;

    // Update all pixels in the image to have the dominant color.
    for (int i = 0; i < image.size(); i++)
    {
        for (int j = 0; j < image[i].size(); j++)
        {
            image[i][j] = dominantPixel;
        }
    }
}
