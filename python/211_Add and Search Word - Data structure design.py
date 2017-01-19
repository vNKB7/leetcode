#!/usr/bin/env python2

class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value = None
        self.children = {}

class WordDictionary(object):

    def __init__(self):
        self.root = TrieNode()


    def addWord(self, word):
        """
        Adds a word into the data structure.
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
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        return self.sub_search(self.root, word, 0)

    def sub_search(self, node, word, index):
        if index == len(word):
            return node.value is not None
        c = word[index]

        if c != '.':
            if c not in node.children:
                return False
            else:
                return self.sub_search(node.children[c], word, index+1)
        else:
            for child in node.children.values():
                if self.sub_search(child, word, index+1):
                    return True
            return False

# Your WordDictionary object will be instantiated and called as such:
obj = WordDictionary()
obj.addWord('bad')
obj.addWord('mad')
obj.addWord('dad')
print(obj.search('..w'))