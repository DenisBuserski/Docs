if __name__ == '__main__':
    n = int(input())
    numbers = range(1, n + 1)
    nums = []

    for number in numbers:
        nums.append(number)

    result = ''.join(map(str, nums))
    print(result)
