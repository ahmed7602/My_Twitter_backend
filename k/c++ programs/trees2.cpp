#include<bits/stdc++.h>
using namespace std;
struct Node {
    int data;
    Node *left,*right;
    Node(int val){
        data=val;
        left = NULL;
        right= NULL;

    }

};
void printLevelorder(Node* root){
    if(root==NULL){
        return;
    }
    queue<Node*> q;
    q.push(root);
    while(q.empty()== false){
        Node* node = q.front();
        cout<<node->data<<" ";
        q.pop();
        if(node->left!=NULL)
        q.push(node->left);
        if(node->right!=NULL)
        q.push(node->right);

    }
}
int main()
{
    Node *root = new Node(1);
    root->left=new Node(2);
    root->right=new Node(3);
    root->left->left=new Node(4);
    root->left->right=new Node(5);
    cout<<"Level order traversal is:";
    printLevelorder(root);
    cout<<"learn coding";
    return 0;

}