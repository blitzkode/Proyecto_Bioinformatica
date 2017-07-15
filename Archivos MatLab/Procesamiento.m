function M=ImagetoArray(A, n1, n2) 
B = imresize (A, [n1 n2]) %ajusta las dimensiones a la imagen
C=rgb2gray(B);  % conversión a escala de grises
umbral=graythresh(C);  % umbral determinado por Matlab entre 0 y 1
D=im2bw(C,umbral);  % conversión a imagen binaria
M=D %retorna la matriz escalada en binario
end
