#!/bin/python3

import math
import os
import random
import re
import sys


if __name__ == '__main__':
    n = int(input().strip())

    if int(n) % 2 != 0:
        print("Weird")
    elif int(n) % 2 == 0 and int(n) in range(2, 6):
        print("Not Weird")
    elif int(n) % 2 == 0 and int(n) in range(6, 21):
        print("Weird")
    elif int(n) % 2 == 0 and int(n) > 20:
        print("Not Weird")
