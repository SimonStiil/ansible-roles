# Ansible Role: proxmox/bootstrap

This role adds a pveproxy certificate for proxmox 8.0+ 

## Requirements

Installation of Proxmox 8.0
Root/sudo level PAM user

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

certificate_path: /etc/pve/local/       # Default path for proxmox certificates
certificate_cert_name: pveproxy-ssl.pem # Default name for pveproxy public certificate 
certificate_key_name: pveproxy-ssl.key  # Default name for pveproxy private key
certificate_root_content:               # PEM Root certificate (certificate chain)
certificate_intermediate_content:       # PEM Intermediate certificate (certificate chain)
certificate_content:                    # PEM Certificate (certificate chain)
certificate_key_content:                # Private key for Certificate 

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
