use classicmodels;

-- Tổng giá trị các order đã xuất kho trong tháng 8 - 2004
SELECT 
    SUM(od.priceEach * od.quantityOrdered) AS money
FROM
    orderdetails od
        INNER JOIN
    orders o ON od.orderNumber = o.orderNumber
WHERE
    o.`status` = 'shipped'
        AND YEAR(shippedDate) = '2004'
        AND MONTH(shippedDate) = '08';

-- profit thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện, liệt kê theo tên
drop view test;
CREATE VIEW test AS
    SELECT 
        od.orderNumber,
        ((od.priceEach - p.buyPrice) * od.quantityOrdered) AS profit
    FROM
        orderdetails od
            INNER JOIN
        products p ON od.productCode = p.productCode;

SELECT 
    c.customerName, sum(t.profit)
FROM
    orders o
        INNER JOIN
    test t ON o.orderNumber = t.orderNumber
        right JOIN
    customers c ON o.customerNumber = c.customerNumber
GROUP BY c.customerName
ORDER BY c.customerName;

-- Lợi nhuận mà mỗi sản phảm mang lại
SELECT 
    p.productCode, p.productName, SUM(t.profit)
FROM
    products p
        INNER JOIN
    test t ON p.productCode = t.productCode
GROUP BY p.productCode
ORDER BY p.productCode;


