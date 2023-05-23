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


int calcheight(node* root){
    if(root==NULL){
        return 0;
    }
    
    return max(calcheight(root->left),calcheight(root->right))+1;
}




int calcdiameter(node* root){
    if(root=NULL){
        return 0;
    }
    int l_height= calcheight(root->left);
    int r_height = calcheight(root->right);
    int currdiameter=l_height+r_height+1;
    int ldiameter= calcdiameter(root->left);
    int rdiameter=calcdiameter(root->right);
    return max(currdiameter,max(ldiameter,rdiameter));
}
 int main()
{
    node *root = new node(1);
    root->left=new node(2);
    root->right=new node(3);
    root->left->left=new node(4);
    root->left->right=new node(5);
    root->right->left=new node(6);
    root->right->left->left=new node(7);

   // cout<<"Maximum height is  :  "<<calcheight(root);
   // cout<<endl;
   cout<<"maximum diameter is : "<<calcdiameter(root);

    cout<<"learn coding";
    return 0;

}