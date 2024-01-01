// This C++ file includes necessary libraries, the "Sharpen.h" header file, and standard C++ headers.
#include "Sharpen.h"    // Header file for the sharpening function.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include <cmath>        // Standard C library for mathematical functions.
#include <algorithm>    // Standard C++ library for algorithms.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to apply a sharpening filter to an image.
// Takes a 2D vector of Pixel objects and a sharpening strength value as input.
void applySharpen(vector<vector<Pixel>> &image, float value)
{
    // 3x3 convolution kernel for sharpening.
    const int kernel[3][3] = {
      {-1, -1, -1},
      {-1,  9, -1},
      {-1, -1, -1}
    };

    int height = image.size();
    int width = image[0].size();

    value = value / 45.0;  // Normalize the sharpening strength value.

    // Create a new 3D vector to store the intermediate results after convolution.
    vector<vector<vector<int>>> newImage(height, vector<vector<int>>(width, vector<int>(3, 0)));

    // Apply convolution using the sharpening kernel.
    for (int i = 1; i < height - 1; ++i) {
        for (int j = 1; j < width - 1; ++j) {
            for (int k = 0; k < 3; ++k) {
                int sum = 0;
                for (int m = -1; m <= 1; ++m) {
                    for (int n = -1; n <= 1; ++n) {
                        // Convolution operation for each color channel (r, g, b).
                        if (k == 0)
                            sum += image[i + m][j + n].r * kernel[m + 1][n + 1];
                        else if (k == 1)
                            sum += image[i + m][j + n].g * kernel[m + 1][n + 1];
                        else if (k == 2)
                            sum += image[i + m][j + n].b * kernel[m + 1][n + 1];
                    }
                }
                newImage[i][j][k] = sum;
            }
        }
    }

    // Update the original image by combining it with the sharpened results.
    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            for (int k = 0; k < 3; ++k) {
                if (k == 0) {
                    // Update the red channel.
                    int delta = newImage[i][j][k] - image[i][j].r;
                    image[i][j].r = min(255, max(0, image[i][j].r + (int)(value * delta)));
                } else if (k == 1) {
                    // Update the green channel.
                    int delta = newImage[i][j][k] - image[i][j].g;
                    image[i][j].g = min(255, max(0, image[i][j].g + (int)(value * delta)));
                } else if (k == 2) {
                    // Update the blue channel.
                    int delta = newImage[i][j][k] - image[i][j].b;
                    image[i][j].b = min(255, max(0, image[i][j].b + (int)(value * delta)));
                }
            }
        }
    }
}
