import helpers

if __name__ == "__main__":
    ip = input("Введите IP хоста: ")
    port_range_from = input("Начальный порт: ")
    port_range_to = input("Конечный порт: ")
    threads = input("Кол-во потоков: ")
    scanner = helpers.portscanner.PortScanner(ip, [int(port_range_from), int(port_range_to)], int(threads))
    scanner.check_ports_async()
    scanner.scan_time()