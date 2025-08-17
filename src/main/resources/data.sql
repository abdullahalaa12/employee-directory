-- Insert sample employees
INSERT INTO employee (id, first_name, last_name, email)
VALUES (1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
    (2, 'Emma', 'Baumgarten', 'emma@luv2code.com'),
    (3, 'Avani', 'Gupta', 'avani@luv2code.com'),
    (4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
    (5, 'Juan', 'Vega', 'juan@luv2code.com');
-- Insert sample users
INSERT INTO users
VALUES (
        'john',
        '{bcrypt}$2a$10$Zt3uN1d3D7guYPvH18EUm.syluACFVN9BKePVczvIPtfYUiqznR6C',
        true
    ),
    (
        'mary',
        '{bcrypt}$2a$10$Zt3uN1d3D7guYPvH18EUm.syluACFVN9BKePVczvIPtfYUiqznR6C',
        true
    ),
    (
        'susan',
        '{bcrypt}$2a$10$Zt3uN1d3D7guYPvH18EUm.syluACFVN9BKePVczvIPtfYUiqznR6C',
        true
    );
INSERT INTO authorities
VALUES ('john', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_MANAGER'),
    ('susan', 'ROLE_EMPLOYEE'),
    ('susan', 'ROLE_MANAGER'),
    ('susan', 'ROLE_ADMIN');