#include<stdio.h>
#include <stdlib.h>

void chachongshuru(int a[], int b[]) {
	int i, j = 0;
	for (i = 0; i < 10; i++) {
		scanf_s("%d", &a[i]);
	}
	for (int i = 0; i < 10; i++)
	{
		if (a[i] != a[i + 1])
		{
			b[j] = a[i];
			j++;
		}
	}
	printf("已删除重复项\n");
	printf("新的数组:\n");
	for (i = 0; i < j; i++) {
		printf("%d  ", b[i]);
	}
}
int main() {
	int a[10], b[100];
	system("color 8E");
	printf("请从小到大输入10个数字:\n");
	chachongshuru(a, b);
	system("pause");
	return 0;
}
