create table m_users(
      m_username varchar_ignorecase(50) not null primary key,
      m_password varchar_ignorecase(50) not null,
      m_enabled boolean not null);

  create table m_authorities (
      m_username varchar_ignorecase(50) not null,
      m_authority varchar_ignorecase(50) not null,
      constraint fk_m_authorities_m_users foreign key(m_username) references m_users(m_username));
  create unique index ix_auth_m_username on m_authorities (m_username,m_authority);