package Netvia.SwapServiceAPI.iam.domain.services;

import Netvia.SwapServiceAPI.iam.domain.model.aggregates.User;
import Netvia.SwapServiceAPI.iam.domain.model.queries.GetAllUsersQuery;
import Netvia.SwapServiceAPI.iam.domain.model.queries.GetUserByIdQuery;
import Netvia.SwapServiceAPI.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
  List<User> handle(GetAllUsersQuery query);
  Optional<User> handle(GetUserByIdQuery query);
  Optional<User> handle(GetUserByUsernameQuery query);
}
