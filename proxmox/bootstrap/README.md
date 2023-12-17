# Ansible Role: proxmox/bootstrap

This role create a bootstraps a fresh proxmox 8.0+ installation for terraform and ansible

## Requirements

Installation of Proxmox 8.0
Root level PAM user

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

    apt_disabled_dir: /etc/apt/sources.list.d-disabled/ # where to move disabled apt lists

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/bootstrap

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
