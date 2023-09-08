# Ansible Role: proxmix/create-vm-terraform

This role creates a vm in proxmox based on a vm template

## Requirements

Installation of Proxmox 8.0
User on PAM user on Proxmox with permissions from 
pveum role add \[USERNAME\] -privs "Datastore.AllocateSpace Datastore.Audit Pool.Allocate Sys.Audit Sys.Console Sys.Modify VM.Allocate VM.Audit VM.Clone VM.Config.CDROM VM.Config.Cloudinit VM.Config.CPU VM.Config.Disk VM.Config.HWType VM.Config.Memory VM.Config.Network VM.Config.Options VM.Migrate VM.Monitor VM.PowerMgmt"
See https://registry.terraform.io/providers/Telmate/proxmox/latest/docs for updated permission list

## Role Variables

Available variables are listed below, along with default values (see `defaults/main.yml`):

  proxmox_terraform_role_dir: /var/proxmox/terraform # Path of Terraform workdir  
  proxmox_terraform_provider_version: 2.9.14         # Version of provider Telmate/proxmox to use  
  proxmox_vm_hostname: MyVM                          # Hostname of the new VM
  proxmox_cloud_image_source: ubuntu-23.04-20230829  # Name of template to use  
  proxmox_vm_disk_location: local-lvm                # Storage location of vm-images
  proxmox_vm_disk_size: 128G                         # Disk space to alocate  
  proxmox_vm_cpu_count: 8                            # Cores to alocate  
  proxmox_vm_memory_size: 8192                       # Memory to alocate (Balloning active)  
  proxmox_vm_boot_order: 1                           # Order of VM's to boot if onboot is enabled  
  proxmox_vm_onboot: true                            # VM Should start at proxmox boot  
  proxmox_vm_bridge: vmbr0                           # Virtual bridge to connect to  
  proxmox_vm_ip: 192.168.1.20                        # Ipaddress of vm after creation  
  proxmox_vm_cidr: 24                                # Netmask in bits  
  proxmox_vm_gateway: 192.168.1.1                    # Gateway for vm to use  
  proxmox_vm_nameserver: 192.168.1.1                 # Nameserver for vm to use  
  proxmox_vm_searchdomain: example.com               # Searchdomains for vm to use  
  proxmox_vm_sshkeys:
  - ssh-ed25519 AAAAC3xxxx ansible@MyVM

## Dependencies

None.

## Example Playbook

    - hosts: pve
      gather_facts: yes
      become: yes
      roles:
        - role: stiil-ansible-roles/proxmox/create-vm-terraform

## License

MIT / BSD

## Author Information

This role was created in 2023 by [Simon Stiil](https://github.com/SimonStiil/).
