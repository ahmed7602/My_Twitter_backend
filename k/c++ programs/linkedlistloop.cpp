#include<iostream>
using namespace std;
class node{
    public:
    int data;
    node* next;
} *first = NULL;
int isLoop(node* f){
    node *p,*q;
    p=q=f;
    do{
        p=p->next;
        q=q->next;
        q=q?q->next:q;

    }
    while( p&&q !=NULL &&p!=q );
    
    {
        if(p==q)
        return 1;
        else 
        return 0;
    }
}
void create(int A[],int n)
{
    int i;
    node *t , *last;
    first =new node;
    first->data =A[0];
    first->next=NULL;
    last = first;
    for(i=1;i<n;i++)
    {
        t = new node;
        t->data=A[i];
        t->next=NULL;
        last->next=t;
        last=t;

    }


}
int main()
{
    node *t1, *t2;
    int A[] = { 10,20,30,40,50};
    create(A,5);
    t1=first->next->next;
    t2=first->next->next->next->next;
    t2->next=t1;
    cout<<isLoop(first);
    return 0;
}