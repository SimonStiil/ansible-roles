# Ansible Role: proxmox/bootstrap-nfs

This role create a bootstraps add NFS storage option proxmox 8.0+ 

## Requirements

Installation of Proxmox 8.0
Root/sudo level PAM user

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

    nfs_path: /mnt/nfs                  # local path for mount
    nfs_server: diskstation.stiil.home  # Server name or ip
    nfs_export: /volume2/proxmox-nfs    # Location of export on server
    nfs_content: backup                 # Storage options https://pve.proxmox.com/wiki/Storage

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/bootstrap-nfs

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
