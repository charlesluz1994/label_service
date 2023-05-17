resource "aws_security_group" "label_sg" {
  name = "label_security_group"
  description = "label service security group"
  vpc_id = aws_vpc.label_vpc_1.id
}

resource "aws_security_group_rule" "sec_group_public_out" {
  from_port         = 0
  protocol          = "-1"
  security_group_id = aws_security_group.label_sg.id
  to_port           = 0
  type              = "egress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "sec_group_ssh_in" {
  from_port         = 22
  protocol          = "tcp"
  security_group_id = aws_security_group.label_sg.id
  to_port           = 22
  type              = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}
resource "aws_security_group_rule" "sec_group_http_in" {
  from_port         = 80
  protocol          = "tcp"
  security_group_id = aws_security_group.label_sg.id
  to_port           = 80
  type              = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_key_pair" "label_key" {
  key_name = "label_service_key"
  public_key = file("~/.ssh/label_service_key.pub")
}