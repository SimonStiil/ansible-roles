# Ansible Role: proxmox/bootstrap-user-personal

This role create a Personal PAM user in proxmox 8.0

## Requirements

Installation of Proxmox 8.0
Root level PAM user

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

  personal_username: simon            # Username to create
  personal_password: supersecret      # See https://docs.ansible.com/ansible/latest/reference_appendices/faq.html#how-do-i-generate-encrypted-passwords-for-the-user-module
  personal_comment:                   # Description
  personal_role: Administrator        # Role for your new personal user

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/bootstrap-user-personal

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
