insert into m_users (m_username, m_password, m_enabled) values ('user', 'user', true);

insert into m_users (m_username, m_password, m_enabled) values ('admin', 'admin', true);

insert into m_authorities (m_username, m_authority) values ('user', 'ROLE_USER');

insert into m_authorities (m_username, m_authority) values ('admin', 'ROLE_ADMIN');