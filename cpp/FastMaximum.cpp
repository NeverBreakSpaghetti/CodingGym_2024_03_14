// Problem:
// https://www.hackerrank.com/contests/coding-gym-brianza-march-2024/challenges/fast-maximum

#include <algorithm>
#include <cassert>
#include <iostream>

namespace {

class Sequence {
public:
  explicit Sequence(int len, int t, int s) : Size_(len), IncTo_(t), Step_(s) {}

  int operator[](int i) const {
    assert(i < this->Size_);
    auto const inc = i < this->IncTo_;
    return (inc * i + !inc * (this->Size_ - i - 1)) * this->Step_;
  }

  int size() const { return this->Size_; }

private:
  int Size_{};
  int IncTo_{};
  int Step_{};
};

} // namespace

int FindPeak(Sequence const &arr) {
  // write your code here
  return {};
}

int main() {
  auto const generator = [] {
    int len{}, incTo{}, step{};
    std::cin >> len >> incTo >> step;
    return Sequence(len, incTo, step);
  }();

  auto const peak = FindPeak(generator);
  std::cout << peak << '\n';
}
