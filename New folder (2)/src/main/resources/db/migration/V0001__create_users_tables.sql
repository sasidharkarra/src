CREATE TABLE users(
  id                BIGSERIAL PRIMARY KEY,
  fName             VARCHAR(100),
  lName             VARCHAR(100),
  email             VARCHAR(100),
  pinCode           BIGSERIAL,
  birthDate         TIMESTAMP,
  status            VARCHAR(10)
);
