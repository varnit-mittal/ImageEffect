// This C++ file includes necessary libraries, the "GaussianBlur.h" header file, and the "Pixel.h" header file.
#include "GaussianBlur.h"
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include <math.h>       // Standard C library for mathematical functions.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to generate the Gaussian kernel
vector<vector<float>> generateGaussianKernel(int kernelSize, float sigma)
{
    // Initialize a 2D vector to store the Gaussian kernel values.
    vector<vector<float>> kernel(kernelSize, vector<float>(kernelSize, 0.0));

    float sum = 0.0;

    // Populate the kernel using the Gaussian function.
    for (int i = 0; i < kernelSize; ++i)
    {
        for (int j = 0; j < kernelSize; ++j)
        {
            int x = i - kernelSize / 2;
            int y = j - kernelSize / 2;
            kernel[i][j] = exp(-(x * x + y * y) / (2 * sigma * sigma)) / (2 * M_PI * sigma * sigma);
            sum += kernel[i][j];
        }
    }

    return kernel;
}

// Function to normalize the kernel
void normalizeKernel(vector<vector<float>> &kernel)
{
    float sum = 0.0;

    // Calculate the sum of all elements in the kernel.
    for(int i = 0; i < kernel.size(); i++)
    {
        for(int j = 0; j < kernel[i].size(); j++)
        {
            sum += kernel[i][j];
        }
    }

    // Normalize the kernel by dividing each element by the sum.
    for(int i = 0; i < kernel.size(); i++)
    {
        for(int j = 0; j < kernel[i].size(); j++)
        {
            kernel[i][j] /= sum;
        }
    }
}

// Function to apply convolution
void applyConvolution(vector<vector<Pixel>> &imageVector, const vector<vector<float>> &kernel)
{
    int m = imageVector.size();
    int n = imageVector[0].size();
    int kernelSize = kernel.size();

    float sumR = 0.0, sumG = 0.0, sumB = 0.0;

    // Iterate over each pixel in the image and apply convolution with the kernel.
    for (int i = 0; i < m; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            sumR = 0.0, sumG = 0.0, sumB = 0.0;

            // Iterate over each element in the kernel.
            for (int ki = 0; ki < kernelSize; ++ki)
            {
                for (int kj = 0; kj < kernelSize; ++kj)
                {
                    int ni = i - kernelSize / 2 + ki;
                    int nj = j - kernelSize / 2 + kj;

                    // Check boundaries to avoid accessing out-of-bounds pixels.
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n)
                    {
                        sumR += imageVector[ni][nj].r * kernel[ki][kj];
                        sumG += imageVector[ni][nj].g * kernel[ki][kj];
                        sumB += imageVector[ni][nj].b * kernel[ki][kj];
                    }
                }
            }

            // Update the pixel values with the convolved results.
            imageVector[i][j].r = static_cast<int>(sumR);
            imageVector[i][j].g = static_cast<int>(sumG);
            imageVector[i][j].b = static_cast<int>(sumB);
        }
    }
}

// Function to apply Gaussian blur
void applyGaussianBlur(vector<vector<Pixel>> &imageVector, float radius)
{
    // Calculate the size of the Gaussian kernel based on the specified radius.
    int kernelSize = static_cast<int>(2 * radius + 1);
    float sigma = max(radius / 2, 0.01f); // Ensure a minimum value for sigma.

    // Generate Gaussian kernel
    vector<vector<float>> kernel = generateGaussianKernel(kernelSize, sigma);

    // Normalize the kernel
    normalizeKernel(kernel);

    // Apply convolution
    applyConvolution(imageVector, kernel);
}
