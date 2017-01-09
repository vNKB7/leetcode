#!/usr/bin/env python


class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value = None
        self.children = {}


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        self.sub_insert(self.root, word, 0)

    def sub_insert(self, node, word, index):
        if index == len(word):
            node.value = word
        else:
            c = word[index]
            if c not in node.children:
                node.children[c] = TrieNode()
            self.sub_insert(node.children[c], word, index+1)

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        return self.sub_search(self.root, word, 0)

    def sub_search(self, node, word, index):
        if index == len(word):
            return word == node.value
        c = word[index]
        if c not in node.children:
            return False
        else:
            return self.sub_search(node.children[c], word, index+1)


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        return self.sub_startsWith(self.root, prefix, 0)

    def sub_startsWith(self, node, prefix, index):
        if index == len(prefix):
            return True
        c = prefix[index]
        if c not in node.children:
            return False
        else:
            return self.sub_startsWith(node.children[c], prefix, index+1)

# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# trie.search("key")

t = Trie()
t.insert("abc")
print(t.search("abc"))
print(t.search("ab"))
t.insert("ab")
print(t.search("ab"))
t.insert("ab")
print(t.search("ab"))
