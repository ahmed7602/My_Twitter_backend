#include<bits/stdc++.h>
using namespace std;
struct node {
    int data;
    node *left,*right;
    node(int val){
        data=val;
        left = NULL;
        right= NULL;

    }

};
void inorderprint(node* root){
    if(root==NULL){
        return;
    }
    inorderprint(root->left);
    cout<<root->data<<" ";
    inorderprint(root->right);
}
 int main()
{
    node *root = new node(1);
    root->left=new node(2);
    root->right=new node(3);
    inorderprint(root);
    cout<<"learn coding";
    return 0;

}