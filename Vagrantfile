# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  config.vm.box="ailispaw/barge"
  config.vm.box_version = "2.7.4"

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access

  config.vm.network "forwarded_port", guest: 8080, host: 8080, host_ip: "127.0.0.1"
  config.vm.network "forwarded_port", guest: 9001, host: 9001, host_ip: "127.0.0.1"
  config.vm.network "forwarded_port", guest: 80, host: 80, host_ip: "127.0.0.1"

  config.vm.synced_folder ".", "/vagrant"


  config.vm.provision "docker" do |d|
      d.build_image "/vagrant/jenkins",
            args: "-t disl-hsqldb-sample/jenkins"

      #Hypersonic SQL database server. JDBC URL: hsql://localhost/hsqldb
      d.run "blacklabelops/hsqldb:latest",
            name: "db",
            args: "-e HSQLDB_DATABASE_ALIAS=hsqldb --net=host"

      d.run "disl-hsqldb-sample/jenkins",
            name: "jenkins",
            args: "-v /vagrant:/var/disl-hsqldb-sample --net=host"

      d.run "nginx:1.12-alpine",
                  name: "nginx",
                  args: "-v /vagrant/build/site:/usr/share/nginx/html:ro -p 80:80"
    end

    # Restart containers using volume mapping to VirtualBox synced folder for every vagrant up.
    # Synced folder are not available in time starting docker daemon during vagrant box boot process.
    # This is required for subsequents start of vagrant box (reload, halt & up.).

    config.vm.provision "shell", inline: "docker restart jenkins", run: "always"
    config.vm.provision "shell", inline: "docker restart nginx", run: "always"


end
