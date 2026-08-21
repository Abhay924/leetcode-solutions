# Write your MySQL query statement below
UPDATE Salary
SET sex = CASE
    WHEN sex='m' THEN 'f'
    ELSE 'm'
END;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna