#!/usr/bin/env python3
import math

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []

        for token in tokens:
            num = None
            try:
                num = int(token)
            except:
                num = None

            if num is None:
                b = stack.pop(-1)
                a = stack.pop(-1)
                if token == '+':
                    stack.append((a+b))
                elif token == '-':
                    stack.append((a-b))
                elif token == '*':
                    stack.append((a*b))
                else:
                    if a * b < 0:
                        stack.append(-(math.fabs(a)//math.fabs(b)))
                    else:
                        stack.append((math.fabs(a)//math.fabs(b)))
            else:
                stack.append(num)
        return int(stack.pop(-1))


s = Solution()
print(s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))