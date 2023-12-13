# Ansible Role: proxmox/bootstrap-user-terraform

This role create a terraform ready PAM user in proxmox 8.0

## Requirements

Installation of Proxmox 8.0
Root level PAM user

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

  terraform_username: terraform-prov   # Username to create
  terraform_password: supersecret      # See https://docs.ansible.com/ansible/latest/reference_appendices/faq.html#how-do-i-generate-encrypted-passwords-for-the-user-module
  terraform_comment: Terraform User    # Description
  terraform_role: TerraformProv        # Create role with this name and set default terraform required permissions

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/bootstrap-user-terraform

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
