# DRY: don't repeat yourself

resource "local_file" "products" {
  count    = 100
  content  = "List of products para el próximo mes"
  filename = "products-${random_string.random[count.index].id}.txt"
}
