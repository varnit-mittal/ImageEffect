#include "Rotation.h"
#include<vector>
#include <cmath>
#include "../Pixel.h"
using namespace std;

//void applyRotation(vector<vector<Pixel>> &imageVector, int value)
//{
//    int rows = imageVector.size();
//    int cols = imageVector[0].size();
//
//    int angle = 0;
//
//    if(value ==1)
//    {
//        vector<vector<Pixel>> tempVector(rows,vector<Pixel>(cols));
//        for(int i=0; i<rows; i++)
//        {
//            for(int j=0; j<cols; j++)
//            {
//                tempVector[i][j] = imageVector[i][j];
//            }
//        }
//        imageVector.resize(cols);
//        for(int i=0; i<cols; i++)
//            imageVector[i].resize(rows);
//        for(int i=0;i<rows;i++)
//        {
//            for(int j=0;j<cols;j++)
//            {
//                imageVector[j][i] = tempVector[i][j];
//            }
//        }
//        for(int i=0;i<cols/2;i++)
//        {
//            for(int j=0;j<rows;j++)
//            {
//                swap(imageVector[i][j],imageVector[i][cols-j-1]);
//            }
//        }
//
//    }
//    if(value ==2)
//    {
//        angle = 180;
//        tempVector.resize(m);
//        for(int i=0; i<m; i++)
//            tempVector[i].resize(n);
//    }
//    if(value ==3)
//    {
//        angle = 270;
//        tempVector.resize(n);
//        for(int i=0; i<n; i++)
//            tempVector[i].resize(m);
//    }
//    if(value == 4)
//        return;
// }


void applyTransposeToMatrix(vector<vector<Pixel>> &matrix)
{
    int rows = static_cast<int>(matrix.size());
    int cols = rows > 0 ? static_cast<int>(matrix[0].size()) : 0;

    vector<vector<Pixel>> transposedMatrix(cols, vector<Pixel>(rows));

    for (int y = 0; y < rows; ++y)
        for (int x = 0; x < cols; ++x)
            transposedMatrix[x][y] = matrix[y][x];
    matrix = transposedMatrix;
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
void applyRotation(vector<vector<Pixel>> &imageVector, int value)
{
    int rows = static_cast<int>(imageVector.size());
    int cols = rows > 0 ? static_cast<int>(imageVector[0].size()) : 0;

    int angle = 0;

    if(value ==1)
    {
        angle = 90;
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
    }
    if(value ==2)
    {
        angle = 180;
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
    }
    if(value ==3)
    {
        angle = 270;
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
        applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(imageVector);
    }
    if(value == 4)
        return;
}


