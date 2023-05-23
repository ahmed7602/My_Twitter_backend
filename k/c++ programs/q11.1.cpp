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
node* findlca(node* root,int n1,int n2){
    if(root==NULL)
    return 0;
    if(n1==root->data||n2==root->data)
    return root;
    node* leftlca=findlca(root->left,n1,n2);
    node* rightlca=findlca(root,n1,n2);
    if(leftlca&&rightlca)
    return root;
    return (leftlca!=NULL)?leftlca:rightlca;
}
int main()
{
    // Let us create binary tree given in the above example
    node * root = new node(1);
    root->left = new node(2);
    root->right = new node(3);
    root->left->left = new node(4);
    root->left->right = new node(5);
    root->right->left = new node(6);
    root->right->right = new node(7);
    cout << "LCA(4, 5) = " << findlca(root, 4, 5)->data;
    cout << "\nLCA(4, 6) = " << findlca(root, 4, 6)->data;
    cout << "\nLCA(3, 4) = " << findlca(root, 3, 4)->data;
    cout << "\nLCA(2, 4) = " << findlca(root, 2, 4)->data;
    return 0;
}