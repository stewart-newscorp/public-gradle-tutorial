import logging
import time

logger = logging.getLogger(__name__)

def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    start_time = time.time()
    result = fibonacci(40)
    # INFO:__main__:Result: 102334155, The code took 10.99 seconds to execute.
    end_time = time.time()
    elapsed_time = round(end_time - start_time, 2)
    logger.info(f"Result: {result}, The code took {elapsed_time} seconds to execute.")