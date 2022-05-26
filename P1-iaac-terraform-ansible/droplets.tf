resource "digitalocean_droplet" "web" {
  count  = 2
  image  = "ubuntu-20-04-x64"
  name   = "web-${count.index}"
  region = "fra1"
  size   = "s-1vcpu-1gb"

  ssh_keys = ["83:0b:2d:83:28:0d:ee:3e:71:5f:99:57:69:52:78:41"]

  provisioner "remote-exec" {
    inline = ["sudo apt update", "sudo apt install python3 -y", "echo Done!"]

    connection {
      host        = self.ipv4_address
      type        = "ssh"
      user        = "root"
      private_key = file(var.pvt_key)
    }
  }

  provisioner "local-exec" {
    command = "ANSIBLE_HOST_KEY_CHECKING=False ansible-playbook -u root -i '${self.ipv4_address},' --private-key ${var.pvt_key} -e 'pub_key=${var.pub_key}' playbook.yml"
  }
}

output "droplet_ip_addresses" {
  value = {
    for droplet in digitalocean_droplet.web:
    droplet.name => droplet.ipv4_address
  }
}

# Llave que se agrega al path
# export DO_PAT="key DO"
# Para ejecutar:
# terraform apply -var "do_token=${DO_PAT}" -var "pvt_key=~/.ssh/id_rsa" -var "pub_key=~/.ssh/id_rsa.pub"
# terraform destroy -var "do_token=${DO_PAT}" -var "pvt_key=~/.ssh/id_rsa" -var "pub_key=~/.ssh/id_rsa.pub"