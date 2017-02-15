#!/usr/bin/env python2

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        num = 0
        op = '+'
        stack = []
        s += '+0'
        for c in s:
            if c == ' ':
                continue
            elif 0 <= ord(c) - ord('0') <= 9:
                num = num * 10 + int(c)
            elif c == '+' or c == '-':
                if op == '*':
                    result = result * num
                elif op == '/':
                    result = result / num
                elif op == '+':
                    result = result + num
                elif op == '-':
                    result = result - num
                while len(stack) > 0 and stack[-1] != '(':
                    op = stack.pop(-1)
                    result = int(stack.pop(-1)) + result if op == '+' else int(stack.pop(-1)) - result
                num = 0
                op = c
            elif c == '*' or c == '/':
                if op == '*':
                    result = result * num
                elif op == '/':
                    result = result / num
                else:
                    stack.append(result)
                    stack.append(op)
                    result = num
                num = 0
                op = c
            elif c == '(':
                stack.append(result)
                stack.append(op)
                result = 0
                op = '+'
            elif c == ')':
                while len(stack) > 0 and stack[-1] != '(':
                    op = stack.pop(-1)
                    result = int(stack.pop(-1)) + result if op == '+' else int(stack.pop(-1)) - result
        return result

s = Solution()
print s.calculate('3+(2*2)+2')





