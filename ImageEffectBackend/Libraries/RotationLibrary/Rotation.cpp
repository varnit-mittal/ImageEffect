#include "Rotation.h"
#include<vector>
#include <cmath>
#include<algorithm>
#include "../Pixel.h"
using namespace std;

vector<vector<Pixel>> applyTransposeToMatrix(vector<vector<Pixel>> &matrix)
{
    int rows = static_cast<int>(matrix.size());
    int cols = rows > 0 ? static_cast<int>(matrix[0].size()) : 0;

    vector<vector<Pixel>> transposedMatrix(cols, vector<Pixel>(rows));

    for (int y = 0; y < rows; ++y)
        for (int x = 0; x < cols; ++x)
            transposedMatrix[x][y] = matrix[y][x];

    return transposedMatrix;
}

void applyFlipToMatrixAboutCentralColumn(vector<vector<Pixel>> &matrix)
{
    int rows = static_cast<int>(matrix.size());
    int cols = rows > 0 ? static_cast<int>(matrix[0].size()) : 0;
    for (int y = 0; y < rows; ++y)
    {
        for (int x = 0; x < cols / 2; ++x)
        {
            auto temp = matrix[y][x];
            matrix[y][x] = matrix[y][cols - x - 1];
            matrix[y][cols - x - 1] = temp;
        }
    }
}

vector<vector<Pixel>> applyRotation(vector<vector<Pixel>> &imageVector, int value)
{
    int rows = static_cast<int>(imageVector.size());
    int cols = rows > 0 ? static_cast<int>(imageVector[0].size()) : 0;

    int angle = 0;

    if(value ==1)
    {
        angle=90;
        vector<vector<Pixel>> transposedMatrix =applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(transposedMatrix);
        return transposedMatrix;
//        applyFlipToMatrixAboutCentralColumn(imageVector);
    }
    if(value ==2)
    {
        angle = 180;
        reverse(imageVector.begin(),imageVector.end());
        return imageVector;
    }
    if(value ==3)
    {
        angle = 270;
        vector<vector<Pixel>> transposedMatrix =applyTransposeToMatrix(imageVector);
        for(int i=0;i<transposedMatrix.size();i++)
        {
            reverse(transposedMatrix[i].begin(),transposedMatrix[i].end());
        }
        applyFlipToMatrixAboutCentralColumn(transposedMatrix);
        return transposedMatrix;
    }

    else
    return imageVector;
}


