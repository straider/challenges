:: Virtualisation ::
====================

# Overview

## What is Virtualisation?

> In computing, [Virtualization](https://en.wikipedia.org/wiki/Virtualization) refers to the act of creating a virtual (rather than actual) version of something, including virtual computer hardware platforms, operating systems, storage devices, and computer network resources.

> A [hypervisor](https://en.wikipedia.org/wiki/Hypervisor) or virtual machine monitor (VMM) is a piece of computer software, firmware or hardware that creates and runs virtual machines. A computer on which a hypervisor runs one or more virtual machines is called a host machine, and each virtual machine is called a guest machine. The hypervisor presents the guest operating systems with a virtual operating platform and manages the execution of the guest operating systems. This contrasts with operating-system-level virtualization, where all instances (usually called containers) must share a single kernel.

> In computing, a [virtual machine](https://en.wikipedia.org/wiki/Virtual_machine) (VM) is an emulation of a computer system. Virtual machines are based on computer architectures and provide functionality of a physical computer. Their implementations may involve specialized hardware, software, or a combination.

## When to use Virtualisation?

> [Virtualization](http://www.vmware.com/solutions/virtualization.html) can increase IT agility, flexibility, and scalability while creating significant cost savings. Workloads get deployed faster, performance and availability increases and operations become automated, resulting in IT that's simpler to manage and less costly to own and operate. Additional benefits include:
- Reduce capital and operating costs.
- Minimize or eliminate downtime.
- Increase IT productivity, efficiency, agility and responsiveness.
- Provision applications and resources faster.
- Enable business continuity and disaster recovery.
- Simplify data center management.
- Build a true Software-Defined Data Center.

## How to use Virtualisation?

> [Kernel-based Virtual Machine](https://en.wikipedia.org/wiki/Kernel-based_Virtual_Machine) is a virtualization infrastructure for the Linux kernel that turns it into a hypervisor. It was merged into the Linux kernel mainline in kernel version 2.6.20, which was released on February 5, 2007. KVM requires a processor with hardware virtualization extensions.

> In computing, [hardware-assisted virtualization](https://en.wikipedia.org/wiki/Hardware-assisted_virtualization) is a platform virtualization approach that enables efficient full virtualization using help from hardware capabilities, primarily from the host processors. Full virtualization is used to simulate a complete hardware environment, or virtual machine, in which an unmodified guest operating system (using the same instruction set as the host machine) executes in complete isolation. Hardware-assisted virtualization was added to x86 processors (Intel VT-x or AMD-V) in 2005 and 2006 (respectively).

> Hardware-assisted virtualization reduces the maintenance overhead of paravirtualization as it reduces (ideally, eliminates) the changes needed in the guest operating system. It is also considerably easier to obtain better performance.

> [Operating-system-level virtualization](https://en.wikipedia.org/wiki/Operating-system-level_virtualization) is a server virtualization method in which the kernel of an operating system allows the existence of multiple isolated user-space instances, instead of just one. Such instances, which are sometimes called containers, software containers, virtualization engines (VEs) or jails (FreeBSD jail or chroot jail), may look and feel like a real server from the point of view of its owners and users.

# Resources

## Articles

- [An Introduction to Virtualization](http://www.kernelthread.com/publications/virtualization/)
- [Top 3 Desktop As A Service (DaaS) Providers Compared](http://www.tomsitpro.com/articles/desktop-as-a-service-providers,2-838.html)
- [What you need to know about cloud desktops and DaaS providers](http://searchvirtualdesktop.techtarget.com/essentialguide/What-you-need-to-know-about-cloud-desktops-and-DaaS-providers)
- [Virtualization vs. Cloud Computing: What's the Difference? - See more at: http://www.businessnewsdaily.com/5791-virtualization-vs-cloud-computing.html#sthash.U443Q2m7.dpuf](http://www.businessnewsdaily.com/5791-virtualization-vs-cloud-computing.html)

## Software

- [VirtualPC](http://www.microsoft.com/en-us/download/details.aspx?id=3702) is a virtualization program for Microsoft Windows. In July 2006 Microsoft released the Windows version as a free product.
- [VirtualBox](https://www.virtualbox.org/)
- [Xen](https://www.xenproject.org/) is a hypervisor using a microkernel design, providing services that allow multiple computer operating systems to execute on the same computer hardware concurrently.
- [Kernel Virtual Machine](http://www.linux-kvm.org/page/Main_Page) or KVM (for Kernel-based Virtual Machine) is a full virtualization solution for Linux on x86 hardware containing virtualization extensions (Intel VT or AMD-V). It consists of a loadable kernel module, kvm.ko, that provides the core virtualization infrastructure and a processor specific module, kvm-intel.ko or kvm-amd.ko. Using KVM, one can run multiple virtual machines running unmodified Linux or Windows images. Each virtual machine has private virtualized hardware.
    - [virt-manager](https://virt-manager.org/) is a desktop user interface for managing virtual machines through libvirt. It primarily targets KVM VMs, but also manages Xen and LXC (linux containers).
    - [oVirt](http://www.ovirt.org/) is a virtualization management application. oVirt serves as the bedrock for Red Hat's Enterprise Virtualization product, and is the "upstream" project where new features are developed in advance of their inclusion in that supported product offering.
    - [libvirt](http://libvirt.org/) is an open source API, daemon and management tool for managing platform virtualization. It can be used to manage KVM, Xen, VMware ESX, QEMU and other virtualization technologies.
    - [libguestfs](http://libguestfs.org/) is a set of tools for accessing and modifying virtual machine (VM) disk images.
