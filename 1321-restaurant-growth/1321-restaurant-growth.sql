# Write your MySQL query statement below
SELECT visited_on,
       SUM(amount) OVER (
           ORDER BY visited_on
           ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
       ) AS amount,
       ROUND(
           AVG(amount) OVER (
               ORDER BY visited_on
               ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
           ),
           2
       ) AS average_amount
FROM (
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
) t
ORDER BY visited_on
LIMIT 100000 OFFSET 6;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna