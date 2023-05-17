resource "aws_vpc" "label_vpc_1" {
  cidr_block = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support = true

  tags = {
    "Name" = "label_service_vpc_1"
  }
}

resource "aws_subnet" "label_subnet" {
  vpc_id = aws_vpc.label_vpc_1.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "us-east-1a"
  map_public_ip_on_launch = true

  tags = {
    Name = "label_service_subnet_public"
  }
}

resource "aws_internet_gateway" "label_igw" {
  vpc_id = aws_vpc.label_vpc_1.id

  tags = {
    Name = "label_service_internet_gateway"
  }
}

resource "aws_route_table" "label_rtb" {
  vpc_id = aws_vpc.label_vpc_1.id

  tags = {
    Name = "label_route_table"
  }
}

resource "aws_route" "label_route" {
  route_table_id = aws_route_table.label_rtb.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id = aws_internet_gateway.label_igw.id
}

resource "aws_route_table_association" "label_rtb_association" {
  route_table_id = aws_route_table.label_rtb.id
  subnet_id = aws_subnet.label_subnet.id
}

resource "aws_instance" "label_ec2" {
  instance_type = "t2.micro"
  key_name = aws_key_pair.label_key.id
  vpc_security_group_ids = [aws_security_group.label_sg.id]
  subnet_id = aws_subnet.label_subnet.id

  ami = data.aws_ami.label_ami.id

  user_data = file("userdata.tpl")
  root_block_device {
    volume_size = 8
  }

  tags = {
    Name = "label_ec2"
  }
}
