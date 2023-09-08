# Ansible Role: proxmix/create-cloudinit

This role create a cloud-init template image in proxmox 8.0

## Requirements

Installation of Proxmox 8.0
User on PAM user on Proxmox with permissions from 
pveum role add \[USERNAME\] -privs "Datastore.AllocateSpace Datastore.Audit Pool.Allocate Sys.Audit Sys.Console Sys.Modify VM.Allocate VM.Audit VM.Clone VM.Config.CDROM VM.Config.Cloudinit VM.Config.CPU VM.Config.Disk VM.Config.HWType VM.Config.Memory VM.Config.Network VM.Config.Options VM.Migrate VM.Monitor VM.PowerMgmt"
See https://registry.terraform.io/providers/Telmate/proxmox/latest/docs for updated permission list

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

  ubuntu_version: "23.04"             # Latest image at time of submission  
  release_date: 20230829              # Latest image at time of submission  
  pve_vm_id: 9000                     # Lets start templates from a high number  
  image_destination: local-lvm        # Default storage for default one node  
  image_folder: /var/cloud-images/    # Storage location for downloaded images  
  proxmox_vm_bridge: vmbr0            # Network bridge id  
  proxmox_vm_memory: 2048             # Template default Memory (Can be changed when creating a VM  
  proxmox_vm_bios: ovmf               # Template default Bios  

Only one template should exists for an ID if you already have a template on ID 9000 change it

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/create-cloudinit

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
