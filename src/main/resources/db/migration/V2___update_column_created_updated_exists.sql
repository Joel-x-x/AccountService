update users
set created = current_timestamp,
    updated = current_timestamp,
    exists = true;
