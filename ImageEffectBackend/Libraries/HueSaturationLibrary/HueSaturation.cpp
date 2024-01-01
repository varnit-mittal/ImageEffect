// This C++ file includes necessary libraries, the "HueSaturation.h" header file, and standard C++ headers.
#include "HueSaturation.h"   // Header file for the hue and saturation adjustment function.
#include <vector>            // Standard C++ library for dynamic arrays (vectors).
#include <algorithm>         // Standard C++ library for algorithms.
#include <cmath>             // Standard C++ library for mathematical functions.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;        // Using the standard namespace for convenience.

// Function to apply hue and saturation adjustment to an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on the specified hue and saturation values.
void applyHueSaturation(vector<vector<Pixel>> &image, float saturationValue, float hueValue) {
    int m = image.size();
    int n = image[0].size();

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            // Convert hue to degrees and ensure saturation is within the valid range [0, 1].
            float h = hueValue * 3.6;
            float s = max(0.0, min(1.0, saturationValue / 100.0));

            // Calculate lightness based on the maximum and minimum RGB values.
            float l = (max({image[i][j].r, image[i][j].g, image[i][j].b}) + min({image[i][j].r, image[i][j].g, image[i][j].b})) / 200.0;

            // Calculate chroma, x, and m values based on the HSL color model.
            float c = (1 - abs(2 * l - 1)) * s;
            float x = c * (1 - abs(fmod(h / 60.0, 2) - 1));
            float m = (l - c) / 2;

            double r1, g1, b1;

            // Convert HSL to RGB based on different hue ranges.
            if (h < 60) {
                r1 = c; g1 = x; b1 = 0;
            } else if (h < 120) {
                r1 = x; g1 = c; b1 = 0;
            } else if (h < 180) {
                r1 = 0; g1 = c; b1 = x;
            } else if (h < 240) {
                r1 = 0; g1 = x; b1 = c;
            } else if (h < 300) {
                r1 = x; g1 = 0; b1 = c;
            } else {
                r1 = c; g1 = 0; b1 = x;
            }

            // Update the pixel values with the adjusted RGB values.
            image[i][j].r = min(255, static_cast<int>(abs((r1 + m)) * 255));
            image[i][j].g = min(255, static_cast<int>(abs(g1 + m) * 255));
            image[i][j].b = min(255, static_cast<int>(abs(b1 + m) * 255));
        }
    }
}
