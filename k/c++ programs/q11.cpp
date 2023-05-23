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
node* lca(node* root,int n1,int n2){
    while(root!=NULL){
        if(root->data>n1 && root->data>n2)
        root=root->left;
       else if(root->data<n1 && root->data<n2)
        root=root->right;
        else break;
    }
    return root;
}
int main()
{
   /* node *root = new node(6);
    root->left=new node(3);
    root->right=new node(9);
    root->left->left=new node(2);
    root->left->right=new node(4);
    //root->right->left=new node(6);
    root->left->right->left=new node(0);

   // cout<<"Maximum height is  :  "<<calcheight(root);

   // cout<<endl;
 int n1 = 2, n2 = 0;
    node *t = lca(root, n1, n2);
    cout << "LCA of " << n1 << " and " << n2 << " is " << t->data<<endl;
   //cout<<"lca is : "<<lca(root,1,2);

    cout<<"\n";
    return 0;
    */
     // shown in the above figure
    node *root = new node(20);
    root->left = new node(8);
    root->right = new node(22);
    root->left->left = new node(4);
    root->left->right = new node(12);
    root->left->right->left = new node(10);
    root->left->right->right = new node(14);
 
    int n1 = 10, n2 = 14;
    node *t = lca(root, n1, n2);
    cout << "LCA of " << n1 << " and " << n2 << " is " << t->data<<endl;
 
    n1 = 14, n2 = 8;
    t = lca(root, n1, n2);
    cout<<"LCA of " << n1 << " and " << n2 << " is " << t->data << endl;
 
    n1 = 10, n2 = 22;
    t = lca(root, n1, n2);
    cout << "LCA of " << n1 << " and " << n2 << " is " << t->data << endl;
    return 0;
}


