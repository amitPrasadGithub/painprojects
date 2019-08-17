#include<stdio.h>
char *reverse_sentence(char name[]);

int main(void)
{
    char name[100];
    printf("\n Enter a message : ");
    gets(name);
    
    char *sumit;
    sumit=reverse_sentence(name);
    printf("\n The reversed sentence is : ");
    for(int i=0; i<50; i++)
    printf("%c", sumit[i]);
}

char* reverse_sentence(char name[])
{
    char *rs=malloc(sizeof(char)*100);
    static j=0;
    int l=string_length(name);
    name[-1]=32;
    for(int i=l-1; i>=-2; i--)
    {
        if(name[i]==32)
        {
            for(int k=i; name[k]!=0; k++)
            {
                rs[j]=name[k];
                j=j+1;
            }
            name[i]='\0';
        }
    }
    
    return rs;
}

int string_length(char c[])
{
    int length=0; 
    for(int i=0; c[i]!=0; i++)
        length++;
    return length;    
}